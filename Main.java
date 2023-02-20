import java.util.*;


////하.물건을 구매해볼까?
//public class Main {
//    public int solution(int num) {
//        int answer = 0;
//        int changes = 1000-num;
//
//        for(int i=0; changes>=500; i++){
//            answer += changes / 500;
//            changes %= 500;
//        }
//        for (int i=0; changes>=100; i++){
//            answer += changes / 100;
//            changes %= 100;
//        }
//        for (int i=0; changes>=50; i++){
//            answer += changes / 50;
//            changes %= 50;
//        }
//        for (int i=0; changes>=10; i++){
//            answer += changes / 10;
//            changes %= 10;
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main method = new Main();
//        int num1 = 160;
//        System.out.println(method.solution(num1));
//    }
//}



////중.동그라미 엑스로 숫자를?
//public class Main {
//    public int solution(String s) {
//        int answer = 0;
//        char[] s_arr = s.toCharArray();
//        int cnt=0;
//
//        for (int i=0; i<s_arr.length; i++){
//            if( s_arr[i] == 'O' ){
//                cnt ++;
//                answer += cnt;
//            }
//            else{
//                cnt = 0;
//            }
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main method = new Main();
//        String s1 = "OOXXOXXOOO";
//        String s2 = "OXOXOXOXOXOXOX";
//        String s3 = "OOOOOOOOOO";
//        String s = "OXOOOXXXOXOOXOOOOOXO";
//        System.out.println(method.solution(s));
//    }
//}



//상.지뢰 탐지가 필요해!
public class Main {
    public char[][] solution(int N, char[][] ary) {
        int[] x = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] y = {0, 0, 1, -1, 1, -1, 1, -1};
        char[][] answer = new char[N][N];
        int cnt = 0;

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (ary[i][j] >= '1' && ary[i][j] <= '9'){
                    answer[i][j] = '*';
                }
                else{
                    cnt = 0;
                    int k=i,l=j;
                    for (k=i-1; k<=i+1; k++ ){
                        for (l=j-1; l<=j+1; l++){
                            if(k<0 || k>N-1 || l<0 || l>N-1){
                                continue;
                            }
                            else{
                                if(ary[k][l] >= '1' && ary[k][l] <= '9'){
                                    cnt += ary[k][l] - '0';
                                }
                            }
                        }
                    }
                    if(cnt > 9){
                        answer[i][j] = 'M';
                    }
                    else
                        answer[i][j] = (char)(cnt + '0');
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int N = 5;
        char[][] chars = {{'1', '.', '.', '.', '.'},
                {'.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '4', '.', '.', '.'},
                {'.', '.', '.', '9', '.'}};

        char[][] chars1 ={{'2', '.', '.', '.',},
                {'.', '.', '9', '.'},
                {'.', '3', '.', '2'},
                {'.', '4', '.', '.'}};
        System.out.println(Arrays.deepToString(method.solution(N, chars)));
    }
}


