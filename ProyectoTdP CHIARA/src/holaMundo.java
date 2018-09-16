public class holaMundo {

	public static void main(String[] args) {
		System.out.println("Hola, Xsoup!");
		
		int x = 0, y = 0;
		boolean[][] mat = new boolean[4][5];
		
		for (int i = 0; i < 14; i++) {
			do {
				x = new java.util.Random().nextInt(4);
				y = new java.util.Random().nextInt(5);
			} while (mat[x][y]); //Deja de buscar cuando encuentra una posición falsa.
			
			mat[x][y] = true;
		}
		
		System.out.println();
		System.out.println("Anduvo:");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		
		int cantKB = 2, cantKA = 3, cantKM = 1;
		
		int cont = 0; boolean quedan = true;
		for (int i = 0; i < 4 && quedan; i++) { //Crear Kamikazes.
			for (int j = 0; j < 5 && quedan; j++) {
				if (!mat[i][j]) {
					mat[i][j] = true;
					cont++;
					
					if (cont == cantKB + cantKM + cantKA)
						quedan = false;
				}
			}
		}
	
		System.out.println();
		System.out.println("Anduvo de nuevo:");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	
	}

}
