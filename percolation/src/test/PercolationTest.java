

import junit.framework.TestCase;

import org.junit.Test;

public class PercolationTest extends TestCase {

	private final static int SIZE = 4;

	@Test
	public void test_close() {
		Percolation percolation = new Percolation(SIZE);
		boolean actual = percolation.isOpen(1, 1);
		assertEquals(false, actual);
	}

	@Test
	public void test_open() {
		Percolation percolation = new Percolation(SIZE);
		percolation.open(1, 1);
		boolean actual = percolation.isOpen(1, 1);
		assertEquals(true, actual);
	}

	@Test
	public void test_simple_percolation() {
		Percolation percolation = new Percolation(SIZE);
		percolation.open(1, 2);
		percolation.open(2, 2);
		percolation.open(3, 2);
		percolation.open(4, 2);
		assertEquals(true, percolation.percolates());
	}

	@Test
	public void test_no_percolation() {
		Percolation percolation = new Percolation(SIZE);
		percolation.open(1, 2);
		percolation.open(3, 2);
		assertEquals(false, percolation.percolates());
	}

	@Test
	public void test_complex_percolation() {
		Percolation percolation = new Percolation(SIZE);
		percolation.open(1, 1);
		percolation.open(1, 2);
		percolation.open(1, 3);
		percolation.open(2, 4);
		percolation.open(3, 4);
		percolation.open(4, 4);
		assertEquals(false, percolation.percolates());
		percolation.open(1, 4);
		assertEquals(true, percolation.percolates());
	}

	@Test
	public void test_complex_percolation_2() {
		Percolation percolation = new Percolation(SIZE);
		percolation.open(1, 1);
		percolation.open(1, 3);
		percolation.open(1, 4);
		percolation.open(2, 2);
		percolation.open(2, 4);
		percolation.open(3, 1);
		percolation.open(3, 2);
		percolation.open(3, 3);
		percolation.open(4, 1);
		percolation.open(4, 3);
		percolation.open(4, 4);
		assertEquals(false, percolation.percolates());
		// Other open site percolates the system !
		percolation.open(2, 1);
		assertEquals(true, percolation.percolates());
	}

	@Test
	public void test_only_one_site() {
		Percolation percolation = new Percolation(1);
		assertEquals(false, percolation.percolates());
	}


}
