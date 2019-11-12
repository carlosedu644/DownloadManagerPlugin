import 'dart:async';
import 'package:flutter/services.dart';

class DownloadPlugin {
  static const MethodChannel _channel = const MethodChannel('download_manager_plugin');

  static Future<void> openWithDownloadManager(String url) async {
    await _channel
        .invokeMethod('openWithDownloadManager', {"url": url});
  }

  static Future<void> openWithWebVideoCast(String url) async {
    await _channel.invokeMethod('openWithWebVideoCast', {"url": url});
  }
}
