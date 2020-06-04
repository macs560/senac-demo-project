
package br.edu.sc.senac.demo.demoproject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")
final class ClientEntity implements Serializable {

		private static final long serialVersionUID = 4391164751402917205L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long clientId;

		private String name;

		private String cargo;

		private String dataNascimento;

		protected ClientEntity() {
		}

		public ClientEntity(final String name, final String cargo, final String dataNascimento) {
			this.name = name;
			this.cargo = cargo;
			this.dataNascimento = dataNascimento;
		}

		@Override
		public String toString() {
			return "ClientEntity [clientId=" + this.clientId + ", name=" + this.name + ", cargo=" + this.cargo
					+ ", dataNascimento=" + this.dataNascimento + "]";
		}

		public Long getClientId() {
			return this.clientId;
		}

		public String getName() {
			return this.name;
		}

		public void setName(final String name) {
			if (name != null) {
				this.name = name;
			}
		}

		public String getCargo() {
			return this.cargo;
		}

		public void setCargo(final String cargo) {
			if (cargo != null) {
				this.cargo = cargo;
			}
		}

		public String getdataNascimento() {
			return this.dataNascimento;
		}

		public void setdataNascimento(final String dataNascimento) {
			if (dataNascimento != null) {
				this.dataNascimento = dataNascimento;
			}
		}

	}
