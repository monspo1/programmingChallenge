
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static int maxGapEfficient(final List<Integer> a) {
		int n  = a.size();
		if(n < 2) return 0;
		int max = 0;
		
        int[] lmin = new int[n];
		int[] rmax = new int[n];
		lmin[0] = a.get(0);
		rmax[n-1] = a.get(n-1);
		
        for(int i =1; i < n; i++) lmin[i] = Math.min(a.get(i), lmin[i-1]);
		for(int i = n-2; i >= 0; i--) rmax[i] = Math.max(a.get(i), rmax[i+1]);
		
		int i =0, j = 0;
		while(i < n && j < n){
			if(lmin[i] < rmax[j]){
				max = Math.max(max, j-i);
				j++;
			} else{
				i++;
			}
		}
		return max;
	}
	
	public static int maximumGapIncomp(final List<Integer> a) {
		int max = 0;
		if(a.size() < 2) return 0;
		ArrayList<Integer> idxArr = new ArrayList<Integer>();
		for(int i = 0; i < a.size(); i++) idxArr.add(i);
		
		quickSort(a, idxArr, 0, a.size()-1);
		
		/* testing1
		for(int i = idxArr.size()-1; i >= 0; i--){
			for(int j = i-1;  j >= 0; j--){
				int tmp = idxArr.get(i)-idxArr.get(j);
				//max =  tmp > max ? tmp : max;
				if(tmp > max){
					System.out.println("idx.get(" + i+ "): " + idxArr.get(i) + " | idx.get("+j+"): " + idxArr.get(j) + " | diff: " + (idxArr.get(i)-idxArr.get(j)));
					max = tmp;
				}
			}
		}
		//*/
		for(int i = 0; i < idxArr.size(); i++){
			for(int j = i+1; j < idxArr.size(); j++){
				int tmp = idxArr.get(j)-idxArr.get(i);
				max =  tmp > max ? tmp : max;
			}
		}
		/* testing2
		for(int i = 0; i < idxArr.size(); i++){
			for(int j = i+1; j < idxArr.size(); j++){
				int tmp = idxArr.get(j) - idxArr.get(i);
				max = tmp > max ? tmp : max;
			}
		}
		/* testing3
		for (int i = idxArr.size() - 1; i >= 0; i--) {
            max = Math.max(max, idxArr.get(i));
            idxArr.set(i, max);
        }
		displayList(idxArr);
		//*/
		return max;
	}
	
	public static void quickSort(List<Integer> a, ArrayList<Integer> idxArr, int start, int end){
		int lo = start;
		int hi = end;
		
		while(lo <= hi){
			int mid = (lo+hi)/2;
			
			while(a.get(lo) < a.get(mid)) lo++;
			while(a.get(hi) > a.get(mid)) hi--;
			
			if(lo <= hi){
				if(a.get(lo) >= a.get(hi)){
					int tmp = a.get(lo);
					a.set(lo, a.get(hi));
					a.set(hi, tmp);
					
					tmp = idxArr.get(lo);
					idxArr.set(lo, idxArr.get(hi));
					idxArr.set(hi, tmp);
				}
			}
			lo++;
			hi--;
		}
		if(start < hi) quickSort(a, idxArr, start, hi);
		if(lo < end) quickSort(a, idxArr, lo, end);
	}
	
	public static void displayList(ArrayList<Integer> a){
    	
    	for(int i = 0; i < a.size(); i++){
    		System.out.print(a.get(i) + " ");
    	}
    	System.out.println();
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
        
        while(sc.hasNext()){
            arr.add(sc.nextInt());
        }
        //displayList(arr);
        //System.out.println(maximumGap(arr));
        System.out.println(maxGapEfficient(arr));
	}
}
/*
Test input
312 61491531 53396637 73678541 1739196 1455400 56739987 39184013 60884235 83991000 21035138 9007360 62827424 71522616 57536032 45318001 55301096 42340428 4730988 66575837 77280456 6071774 9535981 75595093 5860088 82419338 99730778 26016825 55657293 1910732 85982947 63765125 6099216 98079496 39213304 48291939 54550025 32693256 88886622 26076749 83104360 83874141 28284682 30558 18457633 64357591 91909800 97021867 99392368 14398272 3648899 10769548 96221105 51077848 27796221 88797963 98886849 8075027 23356933 39612192 31631435 34637806 65705189 1875581 71384980 93146849 84566697 79660781 64509825 26838101 69055010 76139150 71799054 96754649 40324823 2238949 19266327 28578253 62926171 26277312 18390609 51168200 95347927 3074598 31633541 32935261 49389808 4272017 49606250 5061197 36849472 38350496 9540077 27642877 75822690 14435752 23802993 26303625 84448310 29017275 78813585 88148847 19591050 8024108 59164456 76648359 31743285 29919022 39187972 27423148 64521704 21602321 18130077 47069771 17110162 93624386 40900867 26087823 59452812 68689155 59892840 30185654 29015413 67823350 53976711 78542602 7025039 76382192 28051278 84084379 58390610 67428074 48137787 51809806 36515601 30344737 58750458 28822960 61820449 3347857 42613237 93489135 94916558 46501114 29322152 41501406 67885717 54695233 4040644 57262955 35261890 30549719 13801771 26206960 90489614 58672726 34288791 66076135 77120374 63057247 22396795 81066580 99530166 74488767 35681118 34063774 9259375 28666767 42184125 37137669 99017736 68806033 86550005 21168031 53072144 70772475 56497948 45897435 69713076 5857599 37076004 47195815 28656821 75021703 94405038 60998883 92097532 94977678 19239885 55466316 95524431 50794922 67626233 422494 58388911 6661027 60274651 9718323 20059261 53724421 45179421 68784550 96783981 41704591 25560099 77794843 90140738 19395625 57716803 39563262 68656127 22960354 20270591 10580437 36614932 24991386 92576352 45549408 62874228 46249889 22255270 95434483 52935157 53013700 83618034 22372338 86811469 12229341 52761448 23567698 86972253 90857492 69070666 66595363 29269048 27302657 63098004 17171960 79893592 94304563 30331338 21645910 11643597 40694142 56400308 1351244 72602719 63169931 16276783 71925415 5232283 68318938 25601593 9531744 86214724 40458760 90416195 96018350 28569591 85131983 10792394 27824047 34789724 5094744 20978300 91442475 59951001 14719003 14625788 36053728 52693681 84607729 56002628 63505136 31431387 33810988 31837257 71595045 20345166 75870017 11236063 55400966 56578183 60206410 37601304 81092194 41932219 73130289 53387310 16919652 17526642 61484938 22283687 81435846 61957465 45409145 64865189 43706931 19150127 34996055 24040792 4209014 80182696 75101885 1561687 73942128 4666657 53152766 69905938 8202430 17135507 55320466 58119752
//*/