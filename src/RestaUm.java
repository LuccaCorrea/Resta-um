
    


import java.util.Scanner;
public class RestaUm {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[][] tabuleiro = new int[4][4];
		int jogador = 1; //jogador 1 começa jogando
		int posx1;
		int posy1;
		int posx2;
		int posy2;
		int pecas=15;  //quantidade de peças = 15
		int d=0, e=0;
		//imprimi o primeiro tabuleiro
		tabuleiro[0][0]=•;
		tabuleiro[0][1]=•;
		tabuleiro[0][2]=•;
		tabuleiro[0][3]=•;
		tabuleiro[1][0]=•;
		tabuleiro[1][1]=•;
		tabuleiro[1][2]=•;
		tabuleiro[1][3]=1;
		tabuleiro[2][0]=1;
		tabuleiro[2][1]=0; //peça vazia =0
		tabuleiro[2][2]=1;
		tabuleiro[2][3]=1;
		tabuleiro[3][0]=1;
		tabuleiro[3][1]=1;
		tabuleiro[3][2]=1;
		tabuleiro[3][3]=1;
		//imprimi o tabuleiro
		for (int i = 0; i < 4; i++)
		{			
			for (int j = 0; j < 4; j++)
			{
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
		do
		{	
			 System.out.println("Jogador: " + jogador + ". Insira as duas posições iniciais: ");
			 posx1 = scan.nextInt(); //LER POSI. x INICIAL
			 posy1 = scan.nextInt(); //LER POSI. y INICIAL
			 System.out.println("Ok, " + jogador + " Agora insira as duas posições finais: ");
			 posx2 = scan.nextInt(); //LER POSI. x FINAL
			 posy2 = scan.nextInt(); //LER POSI. y FINAL
			 boolean jogadaValida = jogar(posx1, posx2, posy1, posy2,tabuleiro, jogador, pecas, d, e);
			 if (jogadaValida)  //se jogada válida...
				{				
				 pecas--;  //diminui uma peça
				 System.out.println("Existe ainda "+ pecas +" Peças");  //imprimi informando quantas peças exixtem
				 if (pecas == 1) //se peças ==1....
						System.out.println("Jogador  "+ jogador+"  venceu!"); //mostra vencedor					
					//troca jogador
					if (jogador == 1)
					{
						jogador = 2;
					}
					else
					{
						jogador = 1;
					}
				}
				else
				{
					System.out.println("Jogada Inválida!!");
				}		
		}while(pecas>1);		               
	}
				static boolean jogar(int posx1, int posx2, int posy1,int posy2, int[][] tabuleiro, int j, int pecas,
						int d, int e)
				{
							//teste se posy1 != posy2 na vertical
					 if (posy1 < posy2 && posx1 != posx2 || posy1 > posy2 && posx1 > posx2 
							 || posy1 < posy2 && posx1 < posx2
							 || posy1 > posy2 && posx1 < posx2)
						{
							return false;
						}
					 //verifica -- Na horizontal
					 if(   posx1==1 && posy1==0 && posx2==1 && posy2==1   //nao existe   1,0 e 1,1
						|| posx1==1 && posy1==1 && posx2==1 && posy2==2   //nao existe   1,1 e 1,2
						|| posx1==1 && posy1==2 && posx2==1 && posy2==3   //nao existe   1,2 e 1,3
						|| posx1==1 && posy1==3 && posx2==1 && posy2==2   //nao existe   1,3 e 1,2
						|| posx1==1 && posy1==2 && posx2==1 && posy2==1   //nao existe   1,2 e 1,1
						|| posx1==1 && posy1==1 && posx2==1 && posy2==0   //nao existe   1,1 e 1,0
						|| posx1==0 && posy1==0 && posx2==0 && posy2==1       //  0,0 e 0,1
						|| posx1==0 && posy1==1 && posx2==0 && posy2==2       //  0,1 e 0,2
						|| posx1==0 && posy1==2 && posx2==0 && posy2==3       //  0,2 e 0,3
						|| posx1==0 && posy1==3 && posx2==0 && posy2==2       //  0,3 e 0,2
						|| posx1==0 && posy1==2 && posx2==0 && posy2==1       //  0,2 e 0,1
						|| posx1==0 && posy1==1 && posx2==0 && posy2==0       //  0,1 e 0,0
						|| posx1==2 && posy1==0 && posx2==2 && posy2==1
						|| posx1==2 && posy1==1 && posx2==2 && posy2==2
						|| posx1==2 && posy1==2 && posx2==2 && posy2==3
						|| posx1==2 && posy1==3 && posx2==2 && posy2==2
						|| posx1==2 && posy1==2 && posx2==2 && posy2==1
						|| posx1==2 && posy1==1 && posx2==2 && posy2==0 
						|| posx1==3 && posy1==0 && posx2==3 && posy2==1
						|| posx1==3 && posy1==1 && posx2==3 && posy2==2
						|| posx1==3 && posy1==2 && posx2==3 && posy2==3
						|| posx1==3 && posy1==3 && posx2==3 && posy2==2
						|| posx1==3 && posy1==2 && posx2==3 && posy2==1
						|| posx1==3 && posy1==1 && posx2==3 && posy2==0 						
					    ) { return false; }
					//verifica -- Na vertical
					 if(   posx1==0 && posy1==0 && posx2==1 && posy2==0   //nao existe   0,0 e 1,0
						|| posx1==1 && posy1==0 && posx2==2 && posy2==0   //nao existe   1,0 e 2,0
						|| posx1==2 && posy1==0 && posx2==3 && posy2==0   //nao existe   2,0 e 3,0
						|| posx1==3 && posy1==0 && posx2==2 && posy2==0   //nao existe   3,0 e 2,0
						|| posx1==2 && posy1==0 && posx2==1 && posy2==0   //nao existe   2,0 e 1,0
						|| posx1==1 && posy1==0 && posx2==0 && posy2==0   //nao existe   1,0 e 0,0
						|| posx1==0 && posy1==1 && posx2==1 && posy2==1       //  
						|| posx1==1 && posy1==1 && posx2==2 && posy2==1       //  
						|| posx1==2 && posy1==1 && posx2==3 && posy2==1       //  
						|| posx1==3 && posy1==1 && posx2==2 && posy2==1       //  
						|| posx1==2 && posy1==1 && posx2==1 && posy2==1       //  
						|| posx1==1 && posy1==1 && posx2==0 && posy2==1       //  
						|| posx1==0 && posy1==2 && posx2==1 && posy2==2
						|| posx1==1 && posy1==2 && posx2==2 && posy2==2
						|| posx1==2 && posy1==2 && posx2==3 && posy2==2
						|| posx1==3 && posy1==2 && posx2==2 && posy2==2
						|| posx1==2 && posy1==2 && posx2==1 && posy2==2
						|| posx1==1 && posy1==2 && posx2==0 && posy2==2 
						|| posx1==0 && posy1==3 && posx2==1 && posy2==3
						|| posx1==1 && posy1==3 && posx2==2 && posy2==3
						|| posx1==2 && posy1==3 && posx2==3 && posy2==3
						|| posx1==3 && posy1==3 && posx2==2 && posy2==3
						|| posx1==2 && posy1==3 && posx2==1 && posy2==3
						|| posx1==1 && posy1==3 && posx2==0 && posy2==3 						
					    ) {	 return false;	}				 
					 if (  posx1 > 3 || posx1 < 0 || posy1 > 3 || posy1 < 0 || posx2>3 || posx2 < 0 || posy2 > 3 
							 || posy1 < 0 || tabuleiro[posx1][posy1] != 1 || tabuleiro[posx2][posy2] != 0 )
						{	return false;	}			 			 
					 if(   posx1==0 && posy1==0 && posx2==0 && posy2==3
				    	|| posx1==0 && posy1==3 && posx2==0 && posy2==0)
				        {	return false;   }
					 if(   posx1==1 && posy1==0 && posx2==1 && posy2==3
						|| posx1==1 && posy1==3 && posx2==1 && posy2==0)
						{	return false;   }
					 if(   posx1==2 && posy1==0 && posx2==2 && posy2==3
					    || posx1==2 && posy1==3 && posx2==2 && posy2==0)
						 {	return false;   }
					 if(   posx1==3 && posy1==0 && posx2==3 && posy2==3
					    || posx1==3 && posy1==3 && posx2==3 && posy2==0)
						 {	return false;   }
					 if(  posx1==3 && posy1==0 && posx2==0 && posy2==0
					                || posx1==0 && posy1==0 && posx2==3 && posy2==0)
					        { return false; }
					 if(  posx1==3 && posy1==1 && posx2==0 && posy2==1
									|| posx1==0 && posy1==1 && posx2==3 && posy2==1)
							{ return false; }
					 if(  posx1==3 && posy1==2 && posx2==0 && posy2==2
									|| posx1==0 && posy1==2 && posx2==3 && posy2==2)
							{ return false; }
					 if(  posx1==3 && posy1==3 && posx2==0 && posy2==3
									 || posx1==0 && posy1==3 && posx2==3 && posy2==3)
							{ return false; }
					 if(  posx1==0 && posy1==1 && posx2==2 && posy2==1)//
					 {
						 if(tabuleiro[1][1]==0){
							 return false;
						 } else
						 tabuleiro[0][1]=0;
						 tabuleiro[2][1]=1;
						 tabuleiro[1][1]=0;
						 System.out.println();
						 print(tabuleiro);						
					 }					
					 else if(posx1==0 && posy1==3 && posx2==0 && posy2==1)//
					 {
						 if(tabuleiro[0][3]==0){
							 return false;
						 } else
						 tabuleiro[0][1]=1;
						 tabuleiro[0][3]=0;
						 tabuleiro[0][2]=0;
						 System.out.println();
						 print(tabuleiro);					
					 }
					 else if(posx1==1 && posy1==1 && posx2==3 && posy2==1)//
					 {
						 if(tabuleiro[2][1]==0){
							 return false;
						 } else
						 tabuleiro[1][1]=0;
						 tabuleiro[2][1]=0;
						 tabuleiro[3][1]=1;
						 System.out.println();
						 print(tabuleiro);						 
					 }
					 else if(posx1==1 && posy1==3 && posx2==1 && posy2==1)//
					 {
						 if(tabuleiro[1][2]==0){
							 return false;
						 } else
						 tabuleiro[1][3]=0;
						 tabuleiro[1][2]=0;
						 tabuleiro[1][1]=1;
						 System.out.println();
						 print(tabuleiro);						 
					 }
					 else if(posx1==0 && posy1==0 && posx2==0 && posy2==2)//
					 {
						 if(tabuleiro[0][1]==0){
							 return false;
						 } else
						 tabuleiro[0][0]=0;
						 tabuleiro[0][1]=0;
						 tabuleiro[0][2]=1;
						 System.out.println();
						 print(tabuleiro);	
					 }
					 else if(posx1==3 && posy1==1 && posx2==1 && posy2==1)//
					 {
						 if(tabuleiro[2][1]==0){
							 return false;
						 } else
						 tabuleiro[3][1]=0;
						 tabuleiro[2][1]=0;
						 tabuleiro[1][1]=1;
						 System.out.println();
						 print(tabuleiro);				  
					 }
					 else if(posx1==3 && posy1==3 && posx2==3 && posy2==1)//
						{
						 if(tabuleiro[3][2]==0){
							 return false;
						 } else
							 tabuleiro[3][3]=0;
							 tabuleiro[3][2]=0;
							 tabuleiro[3][1]=1;
							 System.out.println();
							 print(tabuleiro);
			         }
					 else if(posx1==0 && posy1==3 && posx2==2 && posy2==3)//
					 {
						 if(tabuleiro[1][3]==0){
							 return false;
						 } else
						 tabuleiro[0][3]=0;
						 tabuleiro[2][3]=1;
						 tabuleiro[1][3]=0;
						 System.out.println();
						 print(tabuleiro);						
					 }
					 else if(posx1==2 && posy1==3 && posx2==0 && posy2==3)//
					 {
						 if(tabuleiro[1][3]==0){
							 return false;
						 } else
						 tabuleiro[2][3]=0;
						 tabuleiro[0][3]=1;
						 tabuleiro[1][3]=0;
						 System.out.println();
						 print(tabuleiro);						
					 }
					 else if(posx1==2 && posy1==3 && posx2==2 && posy2==1)//
					 {
						 if(tabuleiro[2][2]==0){
							 return false;
						 } else
						 tabuleiro[2][3]=0;
						 tabuleiro[2][2]=0;
						 tabuleiro[2][1]=1;
						 System.out.println();
						 print(tabuleiro);						
					 }
					 else if(posx1==0 && posy1==3 && posx2==2 && posy2==3)//
					 {
						 if(tabuleiro[1][3]==0){
							 return false;
						 } else
						 tabuleiro[0][3]=0;
						 tabuleiro[1][3]=0;
						 tabuleiro[2][3]=1;
						 System.out.println();
						 print(tabuleiro);						
					 }
					 else if(posx1==0 && posy1==2 && posx2==2 && posy2==2)//
					 {
						 if(tabuleiro[1][2]==0){
							 return false;
						 } else
						 tabuleiro[0][2]=0;
						 tabuleiro[1][2]=0;
						 tabuleiro[2][2]=1;
						 System.out.println();
						 print(tabuleiro);						 
					 }
					 else if(posx1==2 && posy1==1 && posx2==0 && posy2==1)//
					 {
						 if(tabuleiro[1][1]==0) {
							 return false;
						 } else
						 tabuleiro[2][1]=0;
						 tabuleiro[1][1]=0;
						 tabuleiro[0][1]=1;
						 System.out.println();
						 print(tabuleiro);						
					 }
					 else if(posx1==1 && posy1==0 && posx2==1 && posy2==2)//
					 {
						 if(tabuleiro[1][1]==0){
							 return false;
						 } else
						 tabuleiro[1][0]=0;
						 tabuleiro[1][1]=0;
						 tabuleiro[1][2]=1;
						 System.out.println();
						 print(tabuleiro);					
					 }
					 else if(posx1==3 && posy1==3 && posx2==1 && posy2==3)//
					 {
						 if(tabuleiro[2][3]==0){
							 return false;
						 } else
						 tabuleiro[3][3]=0;
						 tabuleiro[2][3]=0;
						 tabuleiro[1][3]=1;
						 System.out.println();
						 print(tabuleiro);						 
					 }
					 else if(posx1==0 && posy1==1 && posx2==0 && posy2==3)//
					 {
						 if(tabuleiro[0][2]==0){
							 return false;
						 } else
						 tabuleiro[0][1]=0;
						 tabuleiro[0][2]=0;
						 tabuleiro[0][3]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==2 && posy1==2 && posx2==0 && posy2==2)//
					 {
						 if(tabuleiro[1][2]==0){
							 return false;
						 } else
						 tabuleiro[2][2]=0;
						 tabuleiro[1][2]=0;
						 tabuleiro[0][2]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==3 && posy1==0 && posx2==3 && posy2==2)//
					 {
						 if(tabuleiro[3][1]==0){
							 return false;
						 } else
						 tabuleiro[3][0]=0;
						 tabuleiro[3][1]=0;
						 tabuleiro[3][2]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==2 && posy1==0 && posx2==2 && posy2==2)//
					 {
						 if(tabuleiro[2][1]==0){
							 return false;
						 } else
						 tabuleiro[2][0]=0;
						 tabuleiro[2][1]=0;
						 tabuleiro[2][2]=1;
						 System.out.println();
						 print(tabuleiro);						 
					 }
					 else if(posx1==1 && posy1==0 && posx2==3 && posy2==0)//
					 {
						 if(tabuleiro[2][0]==0){
							 return false;
						 } else
						 tabuleiro[1][0]=0;
						 tabuleiro[2][0]=0;
						 tabuleiro[3][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==1 && posy1==3 && posx2==3 && posy2==3)//
					 {
						 if(tabuleiro[2][3]==0) {
							 return false;
						 } else
						 tabuleiro[1][3]=0;
						 tabuleiro[2][3]=0;
						 tabuleiro[3][3]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==1 && posy1==2 && posx2==1 && posy2==0)//
					 {
						 if(tabuleiro[1][1]==0){
							 return false;
						 } else
						 tabuleiro[1][2]=0;
						 tabuleiro[1][1]=0;
						 tabuleiro[1][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==2 && posy1==1 && posx2==2 && posy2==3)//
					 {
						 if(tabuleiro[2][2]==0){
							 return false;
						 } else
						 tabuleiro[2][1]=0;
						 tabuleiro[2][2]=0;
						 tabuleiro[2][3]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==1 && posy1==2 && posx2==3 && posy2==2)//
					 {
						 if(tabuleiro[2][2]==0){
							 return false;
						 } else
						 tabuleiro[1][2]=0;
						 tabuleiro[2][2]=0;
						 tabuleiro[3][2]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==1 && posy1==1 && posx2==1 && posy2==3)//
					 {
						 if(tabuleiro[1][2]==0){
							 return false;
						 } else
						 tabuleiro[1][1]=0;
						 tabuleiro[1][2]=0;
						 tabuleiro[1][3]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==2 && posy1==0 && posx2==0 && posy2==0)//
					 {
						 if(tabuleiro[1][0]==0){
							 return false;
						 } else
						 tabuleiro[2][0]=0;
						 tabuleiro[1][0]=0;
						 tabuleiro[0][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==3 && posy1==1 && posx2==3 && posy2==3)//
					 {
						 if(tabuleiro[3][2]==0){
							 return false;
						 } else
						 tabuleiro[3][1]=0;
						 tabuleiro[3][2]=0;
						 tabuleiro[3][3]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==3 && posy1==2 && posx2==1 && posy2==2)//
					 {
						 if(tabuleiro[2][2]==0) {
							 return false;
						 } else
						 tabuleiro[3][2]=0;
						 tabuleiro[2][2]=0;
						 tabuleiro[1][2]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==2 && posy1==2 && posx2==2 && posy2==0)//
					 {
						 if(tabuleiro[2][1]==0){
							 return false;
						 } else
						 tabuleiro[2][2]=0;
						 tabuleiro[2][1]=0;
						 tabuleiro[2][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==0 && posy1==0 && posx2==2 && posy2==0)//
					 {
						 if(tabuleiro[1][0]==0){
							 return false;
						 } else
						 tabuleiro[0][0]=0;
						 tabuleiro[1][0]=0;
						 tabuleiro[2][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==3 && posy1==2 && posx2==3 && posy2==0)
					 {
						 if(tabuleiro[3][1]==0){
							 return false;
						 } else
						 tabuleiro[3][2]=0;
						 tabuleiro[3][1]=0;
						 tabuleiro[3][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					 else if(posx1==3 && posy1==0 && posx2==1 && posy2==0)//
					 {
						 if(tabuleiro[2][0]==0){
							 return false;
						 } else
						 tabuleiro[3][0]=0;
						 tabuleiro[2][0]=0;
						 tabuleiro[1][0]=1;
						 System.out.println();
						 print(tabuleiro);
					 }
					return true;
				}				
				//PARTE DE IMPRIMIR do MÉTODO print
				static void print(int[][] m)
				{
					for (int i = 0; i < 4; i++)
					{						
						for (int j = 0; j < 4; j++)
						{
							System.out.print(m[i][j] + " ");
						}
						System.out.println();
					}
 } 