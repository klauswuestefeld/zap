package zap;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] nums = {45, 78, 142, 183, 221, 12, 71, 15, 100000000, 2003204123, -1231243124, 1232143, 0, 1, 1234, -123425642};
		
		//Comeco //////////////////////////////
		
		int o = 0;
		while (true){
			int i = 0;
			while (true) {
				
				// if (nums[i] > maior) maior = nums[i];
				
				if (nums[i] > nums[i + 1]){
					int lembrado = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = lembrado;
				}
				
				
				i = i + 1;
				if (i == nums.length - 1) break;
				System.out.println("Ordenado: " + Arrays.toString(nums));
			}
			o = o + 1;
			if (o == nums.length - 1) break;
			
		}
		
		
		//Fim /////////////////////////////////
		
		System.out.println("Ordenado: " + Arrays.toString(nums));

	}

}
