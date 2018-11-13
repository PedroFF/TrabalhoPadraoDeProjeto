package model;

public enum EnumStatePedido implements StrategyInterface{
    AGUARDANDO{
        @Override
        public String getDescricao(){
            return "Aguardando Confirmação";
        }
        
        @Override
        public String getStatus(){
            return "Aguardando";
        }
    },    
    CANCELADO{
        @Override
        public String getDescricao(){
            return "Pedido Cancelado";
        }
        
        @Override
        public String getStatus(){
            return "Cancelado";
        }
    },
    CONFIRMACAO{
        @Override
        public String getDescricao(){
            return "Pedido Confirmado pelo Restaurante";
        }
        
        @Override
         public String getStatus(){
            return "Confirmacao";
        }
    },
    PREPARANDO{
        @Override
        public String getDescricao(){
            return "Preparando Pedido";
        }
        @Override
         public String getStatus(){
            return "Preparando";
        }
    },
    SAINDOENTREGA{
        @Override
        public String getDescricao(){
            return "Pedido saiu para Entrega";
        }
        @Override
         public String getStatus(){
            return "SaindoEntrega";
        }
    },
    CONCLUIDO{
        @Override
        public String getDescricao(){
            return "Pedido entregue e concluído";
        }
        @Override
         public String getStatus(){
            return "Concluido";
        }
    }

}