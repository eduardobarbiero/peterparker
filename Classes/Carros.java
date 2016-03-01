import java.util.Set;


public class Carros {
	
	private Long id;
	
	private String placa;
	
	private String cor;
	
	private Set<Tickets> tickets;
	
	public Set<Tickets> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Tickets> tickets) {
		this.tickets = tickets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
