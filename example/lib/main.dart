import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:open_download_manager/open_download_manager.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
    
  }


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Container(
          child: Center(
            child: InkWell(
              child: Text('click me'),
              onTap: (){
                DownloadPlugin.openWithDownloadManager('https://www.youtube.com/watch?v=hBP-NzOadL0');
              },
            ),
          )
          )
      ),
    );
  }
}
