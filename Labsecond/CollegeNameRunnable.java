class CollegeNameRunnable implements Runnable {
    private String collegeName;

    public CollegeNameRunnable(String collegeName) {
        this.collegeName = collegeName;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(collegeName);
        }
    }

    public static void main(String[] args) {
        CollegeNameRunnable task = new CollegeNameRunnable("Nepal College Of Infotmation Technology");
        Thread thread = new Thread(task);
        thread.start();
    }
}
