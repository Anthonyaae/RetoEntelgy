package animales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.retotecnico.beans.Acuatico;
import com.retotecnico.beans.Animal;
import com.retotecnico.beans.Terrestre;
import com.retotecnico.beans.Volador;
import com.retotecnico.enums.TiposAnimalesEnum;

public class AnimalTest {
	private List<Animal> animales;

	@BeforeEach
	void setUp() {
		animales = new ArrayList<>();
		animales.add(new Terrestre("Perro", "Ladra"));
		animales.add(new Volador("Águila", "Chilla"));
		animales.add(new Acuatico("Delfín", "Chasquea"));
	}

	@Test
	void testCreacionAnimales() {
		assertEquals("Perro", animales.get(0).getNombre());
		assertEquals("Águila", animales.get(1).getNombre());
		assertEquals("Delfín", animales.get(2).getNombre());
	}

	@Test
	void testTiposAnimales() {
		assertEquals("Terrestre", animales.get(0).getTipo());
		assertEquals("Volador", animales.get(1).getTipo());
		assertEquals("Acuático", animales.get(2).getTipo());
	}

	@Test
	void testEmisionSonido() {
		assertEquals(" hace: Ladra", animales.get(0).emitirSonido());
		assertEquals(" hace: Chilla", animales.get(1).emitirSonido());
		assertEquals(" hace: Chasquea", animales.get(2).emitirSonido());
	}

	@Test
	void testAgrupacionPorTipo() {
		Map<String, List<Animal>> agrupados = animales.stream().collect(Collectors.groupingBy(Animal::getTipo));

		assertEquals(1, agrupados.get("Terrestre").size());
		assertEquals(1, agrupados.get("Volador").size());
		assertEquals(1, agrupados.get("Acuático").size());
	}

	@Test
	void testEnumTiposAnimales() {
		assertEquals(TiposAnimalesEnum.TERRESTRE, TiposAnimalesEnum.fromString("Terrestre"));
		assertEquals(TiposAnimalesEnum.VOLADOR, TiposAnimalesEnum.fromString("Volador"));
		assertEquals(TiposAnimalesEnum.ACUATICO, TiposAnimalesEnum.fromString("Acuatico"));
	}
}
