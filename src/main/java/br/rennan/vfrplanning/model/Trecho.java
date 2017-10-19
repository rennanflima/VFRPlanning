/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author rennan.lima
 */
@Entity
public class Trecho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String origem;
    @NotNull
    @Column(nullable = false)
    private String destino;
    @NotNull
    @Column(nullable = false)
    private Double distancia;
    @NotNull
    @Column(name = "rumo_magnetico", nullable = false)
    private Integer rumoMagnetico;
    @NotNull
    @Column(name = "velocidade_indicada", nullable = false)
    private Integer velocidadeIndicada;
    @NotNull
    @Column(nullable = false)
    private String altitude;
	@Enumerated(EnumType.STRING)
	@Column(name = "regra_par_impar")
    private RegraParImpar regraPI;
	private Boolean rea;
    @Column(name = "direcao_vento_voo")
    private Integer direcaoVentoVoo;
    @Column(name = "velocidade_vento_voo")
    private Integer velocidadeVentoVoo;
    @Column(name = "velocidade_aerodinamica")
    private Integer velocidadeAerodinamica;
    @Column(name = "velocidade_solo")
    private Integer velocidadeSolo;
    @Column(name = "duracao_estimada_trecho", nullable = false)
    private LocalTime duracaoEstimadaTrecho;
    @Column(name = "hora_estimada_sobrevoo")
    private LocalTime horaEstimadaSobrevoo;
    private Double combustivel;
    @Column(columnDefinition = "text")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "plano_de_voo_id", nullable = false)
    private PlanoDeVoo planoDeVoo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getRumoMagnetico() {
        return rumoMagnetico;
    }

    public void setRumoMagnetico(Integer rumoMagnetico) {
        this.rumoMagnetico = rumoMagnetico;
    }

    public Integer getVelocidadeIndicada() {
        return velocidadeIndicada;
    }

    public void setVelocidadeIndicada(Integer velocidadeIndicada) {
        this.velocidadeIndicada = velocidadeIndicada;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }
    
    public Boolean getRea() {
		return rea;
	}

	public void setRea(Boolean rea) {
		this.rea = rea;
	}

	public RegraParImpar getRegraPI() {
		return regraPI;
	}

	public void setRegraPI(RegraParImpar regraPI) {
		this.regraPI = regraPI;
	}

	public Integer getDirecaoVentoVoo() {
        return direcaoVentoVoo;
    }

    public void setDirecaoVentoVoo(Integer direcaoVentoVoo) {
        this.direcaoVentoVoo = direcaoVentoVoo;
    }

    public Integer getVelocidadeVentoVoo() {
        return velocidadeVentoVoo;
    }

    public void setVelocidadeVentoVoo(Integer velocidadeVentoVoo) {
        this.velocidadeVentoVoo = velocidadeVentoVoo;
    }

    public Integer getVelocidadeAerodinamica() {
		return velocidadeAerodinamica;
	}

	public void setVelocidadeAerodinamica(Integer velocidadeAerodinamica) {
		this.velocidadeAerodinamica = velocidadeAerodinamica;
	}

	public Integer getVelocidadeSolo() {
        return velocidadeSolo;
    }

    public void setVelocidadeSolo(Integer velocidadeSolo) {
        this.velocidadeSolo = velocidadeSolo;
    }

    public LocalTime getDuracaoEstimadaTrecho() {
        return duracaoEstimadaTrecho;
    }

    public void setDuracaoEstimadaTrecho(LocalTime duracaoEstimadaTrecho) {
        this.duracaoEstimadaTrecho = duracaoEstimadaTrecho;
    }

    public LocalTime getHoraEstimadaSobrevoo() {
        return horaEstimadaSobrevoo;
    }

    public void setHoraEstimadaSobrevoo(LocalTime horaEstimadaSobrevoo) {
        this.horaEstimadaSobrevoo = horaEstimadaSobrevoo;
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PlanoDeVoo getPlanoDeVoo() {
        return planoDeVoo;
    }

    public void setPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        this.planoDeVoo = planoDeVoo;
    }
    
    public void defineRegraParImpar(){
		if(this.rumoMagnetico >= 180 || this.rumoMagnetico <= 359) {
			this.regraPI = RegraParImpar.PAR;
		} else {
			this.regraPI = RegraParImpar.IMPAR;
		}
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trecho other = (Trecho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void calcularVelocidadeAerodinamica() {
    	if(this.altitude != null && this.velocidadeIndicada != null) {
    		double va = ((this.velocidadeIndicada*0.02)*(retornaAltitudeInteira()/1000))+this.velocidadeIndicada;
    		Long aux = Math.round(va);
    		this.velocidadeAerodinamica = Integer.valueOf(aux.intValue());
    	}
    }
    
    public void calcularVelocidadeSolo() {
    	if(this.direcaoVentoVoo == null && this.velocidadeVentoVoo == null){
    		this.direcaoVentoVoo = 1;
    		this.velocidadeVentoVoo = 1;
    	}
    	double be30 = (Math.PI/180)*this.direcaoVentoVoo;
    	double bd30 = (Math.PI/180)*this.rumoMagnetico; 
    	double bf30 = ((this.velocidadeVentoVoo/this.velocidadeAerodinamica)*Math.sin(be30-bd30));
    	double vs = ((this.velocidadeAerodinamica * Math.sqrt(1 - Math.pow(bf30,2))) - (this.velocidadeVentoVoo * Math.cos(be30-bd30)));
    	Long aux = Math.round(vs);
    	this.velocidadeSolo = Integer.valueOf(aux.intValue());
    }
    
    @Transient
    public Integer retornaAltitudeInteira() {
    	Integer alt = null;
    	if(this.altitude.charAt(0) == 'A') {
    		alt = Integer.parseInt(this.altitude.substring(1, this.altitude.length()));
    	}else {
    		alt = Integer.parseInt(this.altitude.substring(2, this.altitude.length()));
    	}
    	alt = alt * 100;
    	return alt;
    } 
    
    public void calcularHoraEstimadaSobrevoo() {
    	double auxvi = (double) this.velocidadeIndicada/60;
    	double auxSegundos = (double) (this.distancia/auxvi)*60;
    	int segundo = (int) auxSegundos % 60;
    	double auxMinutos = (double) auxSegundos / 60;
    	int minuto = (int) auxMinutos % 60;
    	int hora = (int) auxMinutos / 60;
    	this.duracaoEstimadaTrecho = LocalTime.of(hora, minuto, segundo);
    } 

}
