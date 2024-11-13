package com.jme3vscode.template.application;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.jme3vscode.template.states.MainState;

public class Main extends SimpleApplication {

    public static void main(String[] args){
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("JME3VSCode");
        settings.setHeight(768);
        settings.setWidth(1024);
        app.setSettings(settings);
        app.showSettings = false;
        app.setDisplayStatView(false);
        app.setDisplayFps(false);
        app.setPauseOnLostFocus(true);
        app.start(); 
    }

    @Override
    public void simpleInitApp() {
        getStateManager().attach(new MainState());
        Spatial tree = assetManager.loadModel("assets/Models/Tree1/Tree1.obj");
        tree.setLocalTranslation(new Vector3f(0, -5, -10)); // 調整位置，使模型位於螢幕中央
        tree.scale(0.5f); // 縮放模型
        rootNode.attachChild(tree);
        cam.setLocation(new Vector3f(0, 5, 15)); // 調整攝影機位置
        cam.lookAt(new Vector3f(0, 0, 0), Vector3f.UNIT_Y); // 調整攝影機焦點
        Spatial car=assetManager.loadModel("assets/Models/Koenigsegg/uploads_files_2792345_Koenigsegg.obj");
        car.setLocalTranslation(new Vector3f(0, 0, -10)); // 調整位置，使模型位於螢幕中央
        car.scale(0.5f); // 縮放模型
        rootNode.attachChild(car);  // 將模型加入場景
        DirectionalLight sun = new DirectionalLight();  // 創建平行光
        sun.setDirection(new Vector3f(-1, -2, -3));// 設定光源方向
        sun.setColor(ColorRGBA.White);  // 設定光源顏色
        rootNode.addLight(sun); // 將光源加入場景
    }
}
