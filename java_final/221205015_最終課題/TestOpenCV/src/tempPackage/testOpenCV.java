package tempPackage;

import java.util.Arrays;

import org.bytedeco.javacpp.indexer.UByteIndexer;
import org.bytedeco.opencv.global.opencv_highgui;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.opencv.core.Core;
import org.opencv.videoio.Videoio;

public class testOpenCV {
	
	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);};
	
	public static int HEIGHT = 0;
	public static int WIDTH = 0;
	public static int Y = 0;
	public static int X = 0;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		
		
		// 分類器
        // https://github.com/opencv/opencv/blob/master/data/haarcascades/haarcascade_frontalface_default.xml
        String faceCascade = "C:/Users/Owner/Documents/eclipse-workspace/Prog3/TestOpenCV/src/tempPackage/haarcascade_frontalface_default.xml";
        CascadeClassifier faceDetector = new CascadeClassifier(faceCascade);

        // Webカメラの読み込み（普通はID:0のようだ）
        VideoCapture cap = new VideoCapture(0);
        
        //cap.set(Videoio.CAP_PROP_FPS, 10.0);

        Mat frame = new Mat();

        // 動画から１フレームを抽出
        while (cap.read(frame)) {
            // 一応コピーを作成
            Mat out = new Mat(frame);
            // 検出結果の収納先（Rectの集合クラス = RectVectorは配列であるとみなせる）
            RectVector detected = new RectVector();
            // 検出処理
            faceDetector.detectMultiScale(frame, detected);
            // 検出結果の範囲を描画
            
            //rは各矩形の領域であり，rectangleは領域の区切りで描写
            Arrays.stream(detected.get()).forEach(r -> opencv_imgproc.rectangle(out, r, new Scalar(0, 255, 0, 0)));
            Arrays.stream(detected.get()).forEach(r -> RGBconverter(out, r));
            
            // GUIに表示
            opencv_highgui.imshow("Web camera <out part>", out);
            // キーボードのqが押されたら終了
            try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
            int key = opencv_highgui.waitKey(1);
            if (key == 'q') {
                break;
            }
        }
        // リソースのクローズ
        cap.release();
        opencv_highgui.destroyAllWindows();
		
	}
	
	private static Rect RGBconverter(Mat mat, Rect A_rect) {
		try {
			if (A_rect == null) {
				return null;
			}else {
				//Mat mat = new Mat();
				Mat rectMat = new Mat(mat, A_rect);
				Mat copy = rectMat.clone();
				
				UByteIndexer srcIndexer = copy.createIndexer();
				UByteIndexer dstIndexer = copy.createIndexer();
				
				int[] values = new int[3];
				System.out.println(values[0] + " " +  values[1] + " " +  values[2]);
				for(int y=A_rect.y()-A_rect.height(); y < A_rect.y(); y=y+50) {
					for(int x=A_rect.x(); x < A_rect.width()+A_rect.x(); x=x+50) {
						WIDTH = A_rect.width();
						HEIGHT = A_rect.height();
						Y = A_rect.y();
						X = A_rect.x();
						System.out.println(".get is this.under");
						srcIndexer.get(x, y,values);
						System.out.println(values.length);
						System.out.println(values[0] + " " +  values[1] + " " +  values[2]);
						//int[] putter = {values[0],values[1],values[2]};
						/*
						dstIndexer.put(x, y, new int[]{values[0],values[1],values[2]});
						dstIndexer.put(x + 1, y, new int[]{values[0],values[1],values[2]});
						dstIndexer.put(x, y + 1, new int[]{values[0],values[1],values[2]});
						dstIndexer.put(x + 1, y + 1, new int[]{values[0],values[1],values[2]});
						*/
						//
						brocking(values,dstIndexer,0,0);
						System.out.println("１ブロックの処理が完了しました");
					}
					System.out.println("xが一周しました");
				}
				System.out.println("yが一周しました");
				
				values = null;
				Rect r = new Rect(copy);
				return r;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void brocking(int[] values, UByteIndexer dstIndexer, int x, int y) {
		if( x > 50 && y > 50 ) {
		}else{
			dstIndexer.put(x, y, new int[]{values[0],values[1],values[2]});
			brocking(values,dstIndexer,x+1,y);
			
			
		}
	}
	
}


