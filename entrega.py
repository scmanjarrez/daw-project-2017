#!/usr/bin/env python3
import os
import zipfile as zf


files = ['mvnw', 'pom.xml', 'entrega.py', 'deploy.sh']
dirs = ['src', '.mvn']
file_name = 'entrega.zip'


def zip_dir(path, zipf):
    for root, dirs, files in os.walk(path):
        for f in files:
            zipf.write(os.path.join(root, f))


def main():
    zipf = zf.ZipFile(file_name, 'w', zf.ZIP_DEFLATED)

    for f in files:
        zipf.write(f)

    for d in dirs:
        zip_dir(d, zipf)

    zipf.close()


if __name__ == '__main__':
    print("Generando .zip...")
    main()
    print("Fichero entrega.zip generado")
