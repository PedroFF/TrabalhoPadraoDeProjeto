package model;

public enum EnumTipoUsuario implements StrategyInterface {
    CLIENTE {
        @Override
        public String getDescricao() {
            return "Cliente";
        }
    }, 
    RESTAURANTE {
        @Override
        public String getDescricao() {
            return "Restaurante";
        }
    };
}
