package com.bravi.mapper.impl;

import com.bravi.entity.Client;
import com.bravi.entity.ClientMayorista;
import com.bravi.entity.ClientMinorista;
import com.bravi.mapper.XMLMapper;
import com.bravi.repository.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ClientMapperImpl implements XMLMapper {

    private final Repository<Client> clientRepository;

    public ClientMapperImpl(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void processElements(Document document) {
        NodeList nodes = document.getElementsByTagName("client");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element clientItem = (Element) nodes.item(i);
            Integer id = Integer.valueOf(clientItem.getAttribute("id"));
            String name = clientItem.getElementsByTagName("name").item(0).getTextContent();
            String direccion = clientItem.getElementsByTagName("direccion").item(0).getTextContent();
            Boolean mayorista = Boolean.valueOf(clientItem.getElementsByTagName("mayorista").item(0).getTextContent());

            Client clientEntity;

            if (Boolean.TRUE.equals(mayorista)) {
                clientEntity = ClientMayorista.builder()
                        .id(id)
                        .name(name)
                        .direccion(direccion)
                        .build();
            } else {
                clientEntity = ClientMinorista.builder()
                        .id(id)
                        .name(name)
                        .direccion(direccion)
                        .build();
            }

            clientRepository.save(clientEntity);
        }
    }
}
