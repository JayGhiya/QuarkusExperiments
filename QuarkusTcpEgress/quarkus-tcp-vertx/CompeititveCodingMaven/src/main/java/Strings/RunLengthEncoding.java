package Strings;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {

    public String runLengthEncoding(String string) {
        // Write your code here.

        char[] arr = string.toCharArray();

        int charCount = 1;

        StringBuilder stringBuilder = new StringBuilder();

        for(int i =0 ; i < arr.length ;i++)
        {
            if( (i+1!=arr.length) && ( (arr[i]!=arr[i+1]) || (charCount==9)) )
            {
                stringBuilder.append(charCount);
                stringBuilder.append(arr[i]);
                charCount=0;
            }

            if(i+1==arr.length)
            {
                if( (i-1==0) || (i-1 >0)) {
                    if (arr[i - 1] == arr[i]) {

                        stringBuilder.append(charCount);
                        stringBuilder.append(arr[i]);
                    }
                    else
                        {
                            stringBuilder.append(1);
                            stringBuilder.append(arr[i]);
                        }

                }
                else
                {
                    stringBuilder.append(1);
                    stringBuilder.append(arr[i]);
                }
            }

            charCount++;
        }

        return stringBuilder.toString();
    }

}
