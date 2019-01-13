# docker and docker-compose

```bash
# Delete all containers
docker rm -vf $(docker ps -a -q)
# Delete all images
docker rmi -f $(docker images -a -q)

# or just delete everything
docker system prune -a
This will remove:
- all stopped containers 
- all volumes not used by at least one container
- all networks not used by at least one container
- all images without at least one container associated to them
```
