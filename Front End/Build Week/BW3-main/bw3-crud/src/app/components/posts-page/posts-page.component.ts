import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { PostInterface } from 'src/app/models/post-interface';
import { PostsServiceService } from 'src/services/posts-service.service';

@Component({
  selector: 'app-posts-page',
  templateUrl: './posts-page.component.html',
  styleUrls: ['./posts-page.component.scss'],
})
export class PostsPageComponent implements OnInit {
  posts!: PostInterface[];

  constructor(private postService: PostsServiceService) {}

  ngOnInit(): void {
    this.postService
      .getPosts()
      .pipe(
        map((postsObject) => {
          return Object.keys(postsObject).map((key: any) => ({
            id: key,
            ...postsObject[key],
          }));
        })
      )
      .subscribe((postsArray: PostInterface[]) => {
        console.log(postsArray);

        this.posts = postsArray;
      });
  }
}
