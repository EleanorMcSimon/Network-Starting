import static org.junit.Assert.*;

import org.junit.Test;

import matrix.netruron;

public class testing {
	netruron n = new netruron();
	@Test
	public void memorytest() {
		n.weightchange(1);
		n.sigmoidA();
		n.weightchange(0);
		n.sigmoidA();
		System.out.print(n.getweight());
		assertNotEquals(0.0,n.getweight());
		
	}

}
