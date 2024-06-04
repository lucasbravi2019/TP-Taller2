package com.bravi.entity;

public class ClientMinorista extends Client {

    @Override
    public boolean isMayorista() {
        return false;
    }

    public static ClientMinoristaBuilder builder() {
        return new ClientMinoristaBuilder();
    }

    public static class ClientMinoristaBuilder {
        private ClientMinorista clientMinorista;

        public ClientMinoristaBuilder() {
            clientMinorista = new ClientMinorista();
        }

        public ClientMinoristaBuilder id(Integer id) {
            if (id != null) {
                clientMinorista.setId(id);
            }
            return this;
        }

        public ClientMinoristaBuilder name(String name) {
            if (name != null) {
                clientMinorista.setName(name);
            }
            return this;
        }

        public ClientMinoristaBuilder direccion(String direccion) {
            if (direccion != null) {
                clientMinorista.setDireccion(direccion);
            }
            return this;
        }

        public ClientMinorista build() {
            return clientMinorista;
        }

    }


}
