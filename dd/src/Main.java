public class Main {

    public static void main(String[] args) {
	int[] nums={2,-4,4,1};
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>=0)
                break;
            System.out.println(i);
        }
    }
}
