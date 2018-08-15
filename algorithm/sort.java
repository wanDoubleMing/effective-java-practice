import java.util.Arrays;

/**
 * DATE: 18/8/15
 *
 * @author: wan
 */
public class sort {

    /**
     * 插入排序,思想:将数字插入已排序好的队列,进行循环。比如第一个与第二个数已经排序,这么第三个数插入队列,以此类推。
     * 1.确认插入次数,即循环次数
     * 2.确认待插入的数字和已排序队列
     * 3.将待插入的数字与排序队列分别比较并判断是否交换位置,同时保存当前元素。
     * @param numbers
     */
    public static void insertSort(int[] numbers){
        if (numbers.length == 0){
            return;
        }

        int current = 0;
        for (int i = 1; i < numbers.length; i++) {
            int readyInsertNum = numbers[i];
            int j = 0;

            while (j < i && numbers[j] < readyInsertNum){
                current = readyInsertNum;
                j++;
            }

            while (j < i && numbers[j] >= readyInsertNum){
                current = numbers[j];
                numbers[j] = readyInsertNum;
                readyInsertNum = current;
                j++;
            }
            numbers[i] = current;
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 2, 6, 1, 7, 5, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
