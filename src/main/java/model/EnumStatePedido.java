package model;

public enum EnumStatePedido implements StrategyInterface{
    AGUARDANDO{
        @Override
        public String getDescricao(){
            return "Aguardando Confirmação";
        }
    },    
    CONFIRMACAO{
        @Override
        public String getDescricao(){
            return "Pedido Confirmado pelo Restaurante";
        }
    },
    PREPARANDO{
        @Override
        public String getDescricao(){
            return "Preparando Pedido";
        }
    },
    SAINDOENTREGA{
        @Override
        public String getDescricao(){
            return "Pedido saiu para Entrega";
        }
    },
    CONCLUIDO{
        @Override
        public String getDescricao(){
            return "Pedido entregue e concluído";
        }
    }

}