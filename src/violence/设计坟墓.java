package violence;

import java.util.Scanner;

/*
 * King George has recently decided that he would like to have a new design for the royal graveyard. 
 * The graveyard must consist of several sections, each of which must be a square of graves. 
 * All sections must have different number of graves. After a consultation with his astrologer, 
 * King George decided that the lengths of section sides must be a sequence of successive positive integer numbers. 
 * A section with side length s contains s2 graves. George has estimated the total number of graves 
 * that will be located on the graveyard and now wants to know all possible graveyard designs satisfying the condition. 
 * Input file contains n --- the number of graves to be located in the graveyard (1 <= n <= 1014 ).
 * On the first line of the output file print k --- the number of possible graveyard designs. 
 * Next k lines must contain the descriptions of the graveyards. Each line must start with l --- the number of 
 * sections in the corresponding graveyard, followed by l integers --- the lengths of section sides (successive positive integer numbers). 
 * Output line's in descending order of l.
 * Input: 2030
 * Output: 
 * 2
 * 4 21 22 23 24
 * 3 25 26 27
 */
public class ��Ʒ�Ĺ {

	// �������������
    static class obj {
        long cnt, l, r;
        public obj(long cnt, long l, long r) {
            this.cnt = cnt;
            this.l = l;
            this.r = r;
        }
    }

    public static long pow(long r) {
        return r * r;
    }

	/* ����ö�ٿ϶���ʱ, ��ȡ����Ч
	 * �Ҷ˵�һֱ����,ֱ��sum���ڵ���n, Ȼ����˵�������С, �Լ������䳤��
	 */
    public static void solve(long n) {
        int p = 0, l = 1, r = 1, term = (int) Math.sqrt(n); // ��಻�ᳬ��sqrt(n)
        long sum = 0;
        obj[] objs = new obj[term];
        while (true) {
            if (sum == n) objs[p++] = new obj(r - l, l, r);
            if (sum >= n) sum -= pow(l++);
            else {
                if (r <= term) sum += pow(r++);
                else break;
            }
        }
        System.out.println(p);
        for (int i = 0; i < p; i++) {
            System.out.print(objs[i].cnt + " ");
            for (long j = objs[i].l; j < objs[i].r; j++) System.out.print(j + " ");
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		solve(n);
		input.close();
	}

}
