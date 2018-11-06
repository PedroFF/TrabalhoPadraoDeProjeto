package model;

public enum EnumStatePedido implements StrategyInterface{
    AGUARDANDO{
        @Override
        public String getDescricao(){
            return "Aguardando Confirmação";
        }
        
        public String getStatus(){
            return "Aguardando";
        }
    },    
    CONFIRMACAO{
        @Override
        public String getDescricao(){
            return "Pedido Confirmado pelo Restaurante";
        }
        
         public String getStatus(){
            return "Confirmacao";
        }
    },
    PREPARANDO{
        @Override
        public String getDescricao(){
            return "Preparando Pedido";
        }
         public String getStatus(){
            return "Preparando";
        }
    },
    SAINDOENTREGA{
        @Override
        public String getDescricao(){
            return "Pedido saiu para Entrega";
        }
         public String getStatus(){
            return "SaindoEntrega";
        }
    },
    CONCLUIDO{
        @Override
        public String getDescricao(){
            return "Pedido entregue e concluído";
        }
         public String getStatus(){
            return "Concluido";
        }
    }

}