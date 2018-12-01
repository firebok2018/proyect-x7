package utils;

public class VerifySingIn {
		private String idUsuario;
		private String password;
		public VerifySingIn(String idUsuario, String password) {
			super();
			this.idUsuario = idUsuario;
			this.password = password;
		}
		
		public VerifySingIn() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(String idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
