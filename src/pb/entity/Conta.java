package pb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta implements AbstractEntity {
	private static final long serialVersionUID = 960912608879894506L;
	private Integer numero;
	private double saldo;

	public Conta() {
		super();
	}

	@Override
	public Integer getId() {
		return numero;
	}

	@Id
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer id) {
		this.numero = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
