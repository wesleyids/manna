## build image
sudo docker build -t manna .

## run image
docker run --network host \
    -d -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=root123 \
    -e MYSQL_DATABASE=manna \
    -e MYSQL_USER=manna \
    -e MYSQL_PASSWORD=manna123 \
    -it manna