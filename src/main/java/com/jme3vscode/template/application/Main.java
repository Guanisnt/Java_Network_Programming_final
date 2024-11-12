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
    }
}
