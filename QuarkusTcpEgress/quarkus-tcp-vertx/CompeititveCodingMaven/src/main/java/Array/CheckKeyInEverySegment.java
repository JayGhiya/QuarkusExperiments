package Array;

//Reference -> https://www.geeksforgeeks.org/check-if-a-key-is-present-in-every-segment-of-size-k-in-an-array/

public class CheckKeyInEverySegment {

    public boolean findXinKWindowSize(int N,int[] arr,int x,int k)
    {
        boolean result = Boolean.TRUE;

        int i =0;
        int endElement =0;
        while(i<N)
        {
            boolean keyInSegment = Boolean.FALSE;
            if(i+k<=N)
            {
                 endElement = i+k;
            }
            else
            {
                endElement =N;
            }

            for (int j = i; j < endElement; j++) {
                    if(arr[j]==x)
                    {
                        keyInSegment = Boolean.TRUE;
                    }
                }

            if(keyInSegment!=Boolean.TRUE)
            {
                return Boolean.FALSE;
            }
                i += k;
        }

        return result;
    }

}
