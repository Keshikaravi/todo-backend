// package com.javaguides.sample.Service;
// import com.javaguides.sample.repository.ProfileRepository;

// public class ImageService {
//     private final ProfileRepository imageRepository;

//     @Autowired
//     public ImageService(ProfileRepository imageRepository) {
//         this.imageRepository = imageRepository;
//     }

//     public void save(ImageRequest imageRequest) {
//         Image image = new Image();
//         image.setName(imageRequest.getName());
//         image.setContentType(imageRequest.getContentType());
//         image.setData(imageRequest.getData());
//         imageRepository.save(image);
//     }
// }
