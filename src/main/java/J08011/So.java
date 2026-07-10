package J08011;


public class So implements Comparable<So>{
    String number;
    int count;
    int stt;

    public String getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public int getStt() {
        return stt;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public int compareTo(So o) {
        if (o.count == this.count){
            return this.stt - o.stt;
        }
        return o.count - this.count;
    }

    public So(String number, int stt, int count) {
        this.number = number;
        this.stt = stt;
        this.count = count;
    }
}
