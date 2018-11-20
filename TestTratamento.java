import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTratamento extends MyMap {

	@Test
	void testTratamento() {
		String valor =  "ASfocas";
		String retornoEsperado = "asfocas";
		String retornoFornecido = tratamento(valor);
		assertEquals(retornoEsperado, retornoFornecido);
	}
	

}
