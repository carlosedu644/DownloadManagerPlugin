package com.example.open_download_manager;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class OpenDownloadManagerPlugin implements MethodCallHandler {
  /** Plugin registration. */
  private Registrar mRegistrar;
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "download_manager_plugin");
    channel.setMethodCallHandler(new OpenDownloadManagerPlugin(registrar));
  }
  OpenDownloadManagerPlugin(Registrar registrar){
    mRegistrar = registrar;
  }

  @TargetApi(16)
  private void openDownloadManager(String url){
   
    Intent intent = new Intent(Intent.ACTION_VIEW);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
      intent.setPackage("com.dv.adm");
    }
    intent.setData(Uri.parse(url));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);

    try {
      if (null != intent)
        mRegistrar.context().startActivity(intent);
    } catch (ActivityNotFoundException e) {
      
    }
  }
  private void openWebVideoCast(String url){

    Uri uri = Uri.parse(url);
    Intent castIntent = new Intent(Intent.ACTION_VIEW);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
        castIntent.setPackage("com.instantbits.cast.webvideo");
    }

    castIntent.setData(Uri.parse(url));
    castIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    castIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
    try {
      if (null != castIntent)
        mRegistrar.context().startActivity(castIntent);
    } catch (ActivityNotFoundException e) {

    }
  }



@Override
  public void onMethodCall(MethodCall call, Result result) {

    if(call.method.equals("openWithDownloadManager")){
      openDownloadManager(call.argument("url").toString());
     
    }
    else if(call.method.equals("openWithWebVideoCast")){
      openWebVideoCast(call.argument("url").toString());
    }
    else {
      result.notImplemented();
    }
  }


}
