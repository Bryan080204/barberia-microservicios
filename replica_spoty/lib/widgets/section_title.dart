import 'package:flutter/material.dart';

class SectionTitle extends StatelessWidget {
  final String text;

  SectionTitle({required this.text});

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: TextStyle(color: Colors.white, fontSize: 22),
    );
  }
}