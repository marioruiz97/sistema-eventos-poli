package edu.politecnicojic.eventos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SistemaDeEventosPoliApplicationTests {

	@Test
	void contextLoads() {
		boolean trueVariable = 5>1;
		assertThat(trueVariable).isTrue();
	}

}
