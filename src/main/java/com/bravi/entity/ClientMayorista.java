package com.bravi.entity;

public class ClientMayorista extends Client {

    @Override
    public boolean isMayorista() {
        return true;
    }

    public static ClientMayorista.ClientMayoristaBuilder builder() {
        return new ClientMayorista.ClientMayoristaBuilder();
    }

    public static class ClientMayoristaBuilder {
        private ClientMayorista clientMayorista;

        public ClientMayoristaBuilder() {
            clientMayorista = new ClientMayorista();
        }

        public ClientMayorista.ClientMayoristaBuilder id(Integer id) {
            if (id != null) {
                clientMayorista.setId(id);
            }
            return this;
        }

        public ClientMayorista.ClientMayoristaBuilder name(String name) {
            if (name != null) {
                clientMayorista.setName(name);
            }
            return this;
        }

        public ClientMayorista.ClientMayoristaBuilder direccion(String direccion) {
            if (direccion != null) {
                clientMayorista.setDireccion(direccion);
            }
            return this;
        }

        public ClientMayorista build() {
            return clientMayorista;
        }

    }
}
