import 'package:flutter/material.dart';

class MusicCard extends StatefulWidget {
  final String title;

  MusicCard({required this.title});

  @override
  State<MusicCard> createState() => _MusicCardState();
}

class _MusicCardState extends State<MusicCard> {
  bool hover = false;

  @override
  Widget build(BuildContext context) {
    return MouseRegion(
      onEnter: (_) {
        setState(() => hover = true);
      },
      onExit: (_) {
        setState(() => hover = false);
      },

      child: AnimatedContainer(
        duration: Duration(milliseconds: 200),

        width: 170,
        margin: EdgeInsets.only(right: 15),
        padding: EdgeInsets.all(10),

        decoration: BoxDecoration(
          color: hover ? Color(0xFF282828) : Color(0xFF181818),
          borderRadius: BorderRadius.circular(10),
        ),

        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [

            // 🔥 IMAGEN + BOTÓN PLAY
            Stack(
              children: [
                Container(
                  height: 140,
                  decoration: BoxDecoration(
                    color: Colors.grey,
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),

                // ▶️ BOTÓN PLAY
                Positioned(
                  bottom: 10,
                  right: 10,
                  child: AnimatedOpacity(
                    duration: Duration(milliseconds: 200),
                    opacity: hover ? 1 : 0,

                    child: CircleAvatar(
                      backgroundColor: Colors.green,
                      child: Icon(Icons.play_arrow, color: Colors.black),
                    ),
                  ),
                )
              ],
            ),

            SizedBox(height: 10),

            // 🎵 TÍTULO
            Text(
              widget.title,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
              ),
            ),

            SizedBox(height: 5),

            // 🎤 SUBTEXTO
            Text(
              "Artista",
              style: TextStyle(color: Colors.grey),
            )
          ],
        ),
      ),
    );
  }
}