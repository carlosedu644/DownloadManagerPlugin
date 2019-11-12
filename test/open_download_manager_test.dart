import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:open_download_manager/open_download_manager.dart';

void main() {
  const MethodChannel channel = MethodChannel('open_download_manager');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  // test('getPlatformVersion', () async {
  //   expect(await OpenDownloadManager.platformVersion, '42');
  // });
}
