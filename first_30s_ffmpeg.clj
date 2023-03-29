#!/usr/bin/env bb

(defn cut-mp3 [input-file output-file]
  (shell/sh "ffmpeg" "-i" input-file "-t" "30" "-c" "copy" output-file))

(cut-mp3 (first *command-line-args*) (second *command-line-args*))
