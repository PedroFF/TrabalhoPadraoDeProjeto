package model;

public enum EnumTipoUsuario implements StrategyInterface {
    CLIENTE {
        @Override
        public String getDescricao() {
            return "Cliente";
        }

        @Override
        public String getStatus() {
            return "CLIENTE";
        }
    }, 
    RESTAURANTE {
        @Override
        public String getDescricao() {
            return "Restaurante";
        }

        @Override
        public String getStatus() {
            return "RESTAURANTE";
        }
    };
}
