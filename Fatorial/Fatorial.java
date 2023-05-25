public class Fatorial {
	private int n;
	private int fat;

	public void calculaFatorial(int numero) {
		setN(numero);
		int fatorial = 1;
		if(n >= 0) {
			for(int i = 1; i <= n; i++) {
				fatorial *= i;
			}
		} else {
			System.out.println("Insira um numero maior do que 0.");
		}
		this.fatorial = fatorial;
	}

	public int getFatorial() {
		return fat;
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}