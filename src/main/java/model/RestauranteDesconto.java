package model;

/**
 *
 * @author pedrofreitas
 */
public class RestauranteDesconto {
    private int idRestauranteDesconto;
    private int qntdNivelum;
    private int qntdNivelDois;
    private int qntdNivelTres;
    private double descontoNivelUm;
    private double descontoNivelDois;
    private double descontoNivelTres;
    private UsuarioRestaurante restaurante;

    public RestauranteDesconto setIdRestauranteDesconto(int idRestauranteDesconto) {
        this.idRestauranteDesconto = idRestauranteDesconto;
        return this;
    }

    public RestauranteDesconto setQntdNivelum(int qntdNivelum) {
        this.qntdNivelum = qntdNivelum;
        return this;
    }

    public RestauranteDesconto setQntdNivelDois(int qntdNivelDois) {
        this.qntdNivelDois = qntdNivelDois;
        return this;
    }

    public RestauranteDesconto setQntdNivelTres(int qntdNivelTres) {
        this.qntdNivelTres = qntdNivelTres;
        return this;
    }

    public RestauranteDesconto setDescontoNivelUm(double descontoNivelUm) {
        this.descontoNivelUm = descontoNivelUm;
        return this;
    }

    public RestauranteDesconto setDescontoNivelDois(double descontoNivelDois) {
        this.descontoNivelDois = descontoNivelDois;
        return this;
    }

    public RestauranteDesconto setDescontoNivelTres(double descontoNivelTres) {
        this.descontoNivelTres = descontoNivelTres;
        return this;
    }

    public RestauranteDesconto setRestaurante(UsuarioRestaurante restaurante) {
        this.restaurante = restaurante;
        return this;
    }
    
    
}
