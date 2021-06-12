package UsbInterface;

public class Computer {

    public void powerOn(){
        System.out.println("笔记本电脑开机");
    }

    public void powerOff(){
        System.out.println("笔记本电脑关机");
    }

    public void useDevice(USB usb){

        usb.open();//打开设备

        if(usb instanceof Mouse){//向下转型一定要先判定
            Mouse mouse = (Mouse) usb;//向下转型
            mouse.click();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.type();
        }

        usb.close();//关闭设备
    }

}
