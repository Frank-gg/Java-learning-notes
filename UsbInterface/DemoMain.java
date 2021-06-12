package UsbInterface;

public class DemoMain {

    public static void main(String[] args) {

        //首先创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();

        //准备一个鼠标，供电脑使用（向上转型）
        USB usbMouse = new Mouse();//多态写法，左父右子
        computer.useDevice(usbMouse);

        //创建一个usb键盘
        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(keyBoard);
        //computer.useDevice(new KeyBoard());//匿名对象写法也正确

        computer.powerOff();

    }
}
