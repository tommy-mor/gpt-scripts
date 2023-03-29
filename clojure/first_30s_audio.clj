(ns audio-cutter
  (:require [overtone.live :as overtone]
            [clojure.java.io :as io]))

(defn cut-audio [audio-file-path output-file-path]
  (let [audio-file (overtone/load-sample audio-file-path)
        audio-file-first-30s (overtone/cut audio-file 0.0 30.0)
        output-file (io/file output-file-path)]
    (overtone/save-sample audio-file-first-30s output-file)))

(defn -main [& args]
  (if-not (= (count args) 2)
    (println "Usage: lein run <audio_file_path> <output_file_path>")
    (let [audio-file-path (first args)
          output-file-path (second args)]
      (cut-audio audio-file-path output-file-path))))

