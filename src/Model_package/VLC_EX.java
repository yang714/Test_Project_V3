package Model_package;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Interface_package.IPC_interface;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.Frame;
import org.bytedeco.opencv.opencv_core.*;

import javax.swing.*;

public class VLC_EX implements IPC_interface {

    public void testzc() throws FrameGrabber.Exception{
        String file = "rtsp";
        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(file);


        grabber.setOption("rtsp_transport", "tcp");

        grabber.setImageWidth(960);
        grabber.setImageHeight(540);
        System.out.println("grabber start");
        try {
            grabber.start();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }

        CanvasFrame canvasFrame = new CanvasFrame("IPcamera");
        JButton jButton = new JButton("off");
//        jButton.setBounds(240, 300,100, 50);
        jButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                canvasFrame.setVisible(false);
//                try {
//                    grabber.stop();
//                } catch (FrameGrabber.Exception e) {
//                    e.printStackTrace();
//                }
            }
        });
        canvasFrame.add(jButton, BorderLayout.SOUTH);



        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvasFrame.setAlwaysOnTop(true);
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        // OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        while (true){
            Frame frame = grabber.grabImage();
            Mat mat = converter.convertToMat(frame);
            canvasFrame.showImage(frame);
        }


    }



}
