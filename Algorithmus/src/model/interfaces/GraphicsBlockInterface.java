package model.interfaces;

import javafx.scene.layout.AnchorPane;

/**
 * 
 * Interfejs przeznaczony dla reprezentacji graficznych. Dzięki niemu możliwe jest odświeżanie
 * grafiki bloku w odpowiedzi na zdarzenia.
 *
 */
public interface GraphicsBlockInterface {
	public void refresh();
	// przygotowanie elementu do wyświetlenia w bloku głównym
	public void prepair(AnchorPane pan);
	
	//usunięcie bloku
	public void delete();
	
}
