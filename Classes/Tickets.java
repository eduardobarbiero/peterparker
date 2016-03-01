import java.util.Calendar;
import java.util.Set;


public class Tickets {
	
	private Long id;
	
	private Long carroId;
	
	private Set<Dispositivos> dispositivos;
	

	public Long getCarroId() {
		return carroId;
	}

	public void setCarroId(Long carroId) {
		this.carroId = carroId;
	}

	public Set<Dispositivos> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Set<Dispositivos> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
