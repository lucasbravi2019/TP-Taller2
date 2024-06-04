package com.bravi.context;

import com.bravi.mapper.XMLMapper;
import com.bravi.mapper.impl.MapperStrategyFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLDataLoader {

    private final Logger log = Logger.getLogger(XMLDataLoader.class.getName());
    private final AppContext appContext;

    public XMLDataLoader(AppContext appContext) {
        this.appContext = appContext;
    }

    public void loadXMLFilesData() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        MapperStrategyFactory mapperStrategyFactory = appContext.getMapperStrategyFactory();
        Set<String> filenames = mapperStrategyFactory.getFilenames();
        for (String filename : filenames) {
            processFile(contextClassLoader, filename, mapperStrategyFactory.getMapper(filename));
        }
    }

    private void processFile(ClassLoader contextClassLoader, String fileName, XMLMapper mapper) {
        try (InputStream stream = contextClassLoader.getResourceAsStream(fileName)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(stream);
            mapper.processElements(document);
        } catch (ParserConfigurationException | SAXException ex) {
            log.log(Level.SEVERE, "Error parsing XML file: {0}", ex.getMessage());
        } catch (IOException ex) {
            log.log(Level.SEVERE, ex.getMessage());
        }
    }

}
